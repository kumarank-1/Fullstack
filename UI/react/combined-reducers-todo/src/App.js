import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import TodoList from './components/TodoList';
import AddTodo from './components/AddTodo';

function App() {
  const todoList = useSelector(state => state.todoList);
  const dispatch = useDispatch();

  const addTodo = todo => {
    dispatch({ type: 'ADD_TODO', payload: todo });
  };

  const removeTodo = id => {
    dispatch({ type: 'REMOVE_TODO', payload: id });
  };

  return (
    <div>
      <h1>Combined Reducers Todo App</h1>
      <AddTodo addTodo={addTodo} />
      <TodoList todos={todoList} removeTodo={removeTodo} />
    </div>
  );
}

export default App;