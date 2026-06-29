package com.funfit.servlet;

import com.funfit.model.Batch;
import com.funfit.repository.BatchRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

@WebServlet("/batches")
public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final BatchRepository batchRepository = new BatchRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            if (id != null && !id.isBlank()) {
                batchRepository.getBatch(parseId(id)).ifPresent(batch -> request.setAttribute("batch", batch));
            }

            List<Batch> batches = batchRepository.getAllBatches();
            request.setAttribute("batches", batches);
            request.getRequestDispatcher("/WEB-INF/views/batches.jsp").forward(request, response);
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
            batchRepository.addBatch(buildBatch(request, false));
            response.sendRedirect(request.getContextPath() + "/batches?message=batch-created");
        } catch (SQLException | IllegalArgumentException exception) {
            forwardError(request, response, exception);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Batch batch = buildBatch(request, true);
            boolean updated = batchRepository.updateBatch(batch);
            String message = updated ? "batch-updated" : "batch-not-found";
            response.sendRedirect(request.getContextPath() + "/batches?message=" + message);
        } catch (SQLException | IllegalArgumentException exception) {
            forwardError(request, response, exception);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = parseId(request.getParameter("id"));
            boolean deleted = batchRepository.deleteBatch(id);
            String message = deleted ? "batch-deleted" : "batch-not-found";
            response.sendRedirect(request.getContextPath() + "/batches?message=" + message);
        } catch (SQLException | IllegalArgumentException exception) {
            forwardError(request, response, exception);
        }
    }

    private Batch buildBatch(HttpServletRequest request, boolean includeId) {
        Batch batch = new Batch();
        if (includeId) {
            batch.setId(parseId(request.getParameter("id")));
        }
        batch.setBatchName(required(request, "batchName"));
        batch.setTimeSlot(required(request, "timeSlot"));
        batch.setInstructorName(required(request, "instructorName"));
        batch.setCapacity(parsePositiveInt(request.getParameter("capacity"), "capacity"));
        batch.setStartTime(LocalTime.parse(required(request, "startTime")));
        batch.setEndTime(LocalTime.parse(required(request, "endTime")));
        return batch;
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
