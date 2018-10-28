import {observable, computed, reaction} from 'mobx';
import TodoModel from '../models/TodoModel'
import * as Utils from '../utils';

class TodoApi {
	fetchTodos = () => request.get('/todos')
}

class TodoStore {
	@observable todos = [];

	constructor(todoApi) {
		this.todoApi = todoApi;
	}

	fetchTodos = async () => {
		const todos = await this.todoApi.fetchTodos();

		runInAction(() => {
			this.todos = todos;
		});
	}
}

//then in your main
const todoApi = new TodoApi();
const todoStore = new TodoStore(todoApi);