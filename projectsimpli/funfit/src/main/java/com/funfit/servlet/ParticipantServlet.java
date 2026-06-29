package com.funfit.servlet;

import com.funfit.model.Batch;
import com.funfit.model.Participant;
import com.funfit.repository.BatchRepository;
import com.funfit.repository.ParticipantRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet("/participants")
public class ParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ParticipantRepository participantRepository = new ParticipantRepository();
    private final BatchRepository batchRepository = new BatchRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String batchIdParameter = request.getParameter("batchId");
            if (batchIdParameter != null && !batchIdParameter.isBlank()) {
                int batchId = parseId(batchIdParameter);
                Optional<Batch> batch = batchRepository.getBatch(batchId);
                request.setAttribute("batch", batch.orElse(null));
                request.setAttribute("participants", participantRepository.getParticipantsByBatch(batchId));
                request.getRequestDispatcher("/WEB-INF/views/participants-by-batch.jsp").forward(request, response);
                return;
            }

            String id = request.getParameter("id");
            if (id != null && !id.isBlank()) {
                participantRepository.getParticipant(parseId(id))
                        .ifPresent(participant -> request.setAttribute("participant", participant));
            }

            List<Participant> participants = participantRepository.getAllParticipants();
            request.setAttribute("participants", participants);
            request.getRequestDispatcher("/WEB-INF/views/participants.jsp").forward(request, response);
        } catch (SQLException | IllegalArgumentException exception) {
            forwardError(request, response, exception);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodOverride = request.getParameter("_method");
        if ("PUT".equalsIgnoreCase(methodOverride)) {
            doPut(request, response);
            return;
        }
        if ("DELETE".equalsIgnoreCase(methodOverride)) {
            doDelete(request, response);
            return;
        }

        try {
            participantRepository.addParticipant(buildParticipant(request, false));
            response.sendRedirect(request.getContextPath() + "/participants?message=participant-created");
        } catch (SQLException | IllegalArgumentException exception) {
            forwardError(request, response, exception);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Participant participant = buildParticipant(request, true);
            boolean updated = participantRepository.updateParticipant(participant);
            String message = updated ? "participant-updated" : "participant-not-found";
            response.sendRedirect(request.getContextPath() + "/participants?message=" + message);
        } catch (SQLException | IllegalArgumentException exception) {
            forwardError(request, response, exception);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = parseId(request.getParameter("id"));
            boolean deleted = participantRepository.deleteParticipant(id);
            String message = deleted ? "participant-deleted" : "participant-not-found";
            response.sendRedirect(request.getContextPath() + "/participants?message=" + message);
        } catch (SQLException | IllegalArgumentException exception) {
            forwardError(request, response, exception);
        }
    }

    private Participant buildParticipant(HttpServletRequest request, boolean includeId) {
        Participant participant = new Participant();
        if (includeId) {
            participant.setId(parseId(request.getParameter("id")));
        }
        participant.setFullName(required(request, "fullName"));
        participant.setEmail(required(request, "email"));
        participant.setPhone(required(request, "phone"));
        participant.setAge(parsePositiveInt(request.getParameter("age"), "age"));
        participant.setGender(required(request, "gender"));
        participant.setBatchId(parseOptionalBatchId(request.getParameter("batchId")));
        participant.setJoinedDate(LocalDate.parse(required(request, "joinedDate")));
        return participant;
    }

    private Integer parseOptionalBatchId(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return parseId(value);
    }

    private String required(HttpServletRequest request, String parameterName) {
        String value = request.getParameter(parameterName);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(parameterName + " is required.");
        }
        return value.trim();
    }

    private int parseId(String value) {
        return parsePositiveInt(value, "id");
    }

    private int parsePositiveInt(String value, String fieldName) {
        try {
            int parsed = Integer.parseInt(value);
            if (parsed <= 0) {
                throw new IllegalArgumentException(fieldName + " must be greater than zero.");
            }
            return parsed;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(fieldName + " must be a valid number.", exception);
        }
    }

    private void forwardError(HttpServletRequest request, HttpServletResponse response, Exception exception)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", exception.getMessage());
        request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
    }
}
