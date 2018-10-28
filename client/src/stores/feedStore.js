import {observable, computed, reaction} from 'mobx';
import FeedModel from '../models/FeedModel'
import * as Utils from '../utils';
import axios from 'axios';

const host =  'http://localhost:8080/';
class feedApi {
	//こんな感じで取ってくるらしい。
	// fetchFeeds = () => axios.get(host + 'greet');
	fetchHello = () => axios.get(host + 'greet');
}

export default class FeedStore {
	@observable feeds = [];

	feedApi;

	// fetchTodos = () => request.get('/todos')

	// in main
	// const todoApi = new TodoApi();
	// const todoStore = new TodoStore();

	constructor(feedApi) {
		this.feedApi = feedApi;
	}

	fetchFeeds = async () => {
		const feeds = await this.feedApi.fetchTodos();

		runInAction(() => {
			this.feeds = feeds;
		});
	}

	@computed get activeFeedCount() {
		return this.feeds.reduce(
			(sum, feed) => sum + (feed.completed ? 0 : 1),
			0
		)
	}

	// @computed get completedCount() {
	// 	return this.todos.length - this.activeTodoCount;
	// }

	subscribeServerToStore() {
		reaction(
			() => this.toJS(),
			feeds => window.fetch && fetch('/api/feeds', {
				method: 'post',
				body: JSON.stringify({ feeds }),
				headers: new Headers({ 'Content-Type': 'application/json' })
			})
		);
	}

	subscribeLocalstorageToStore() {
		reaction(
			() => this.toJS(),
			feeds => localStorage.setItem('mobx-react-feedmvc-feeds', JSON.stringify({ feeds }))
		);
	}

	addFeed (title) {
		this.feeds.push(new FeedModel(this, Utils.uuid(), title, false));
	}

	//
	// toggleAll (checked) {
	// 	this.todos.forEach(
	// 		todo => todo.completed = checked
	// 	);
	// }
	//
	// clearCompleted () {
	// 	this.todos = this.todos.filter(
	// 		todo => !todo.completed
	// 	);
	// }
	//

	toJS() {
		return this.feeds.map(feed => feed.toJS());
	}

	static fromJS(array) {
		const feedStore = new FeedStore();
		feedStore.feeds = array.map(item => FeedModel.fromJS(feedStore, item));
		return feedStore;
	}
}
