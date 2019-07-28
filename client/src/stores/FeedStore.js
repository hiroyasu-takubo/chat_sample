import {observable, computed, reaction} from 'mobx';
// import FeedModel from '../models/FeedModel'
// import * as Utils from '../utils';
import axios, {AxiosRequestConfig, AxiosResponse} from 'axios';
const URLSearchParams = require('url').URLSearchParams;
const host =  'https://localhost:8080/';

export default class FeedStore {
	@observable feeds = [];

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

	autorun(() => {
		console.log(feeds);
	});

	// fetchFeeds = async () => {
	// 	const feeds = await this.feedApi.fetchTodos();
	//
	// 	runInAction(() => {
	// 		this.feeds = feeds;
	// 	});
	// };

	//後でaxiosを使った非同期通信に変更する。
	api = axios.create({
		baseURL: host,
		headers: {'Content-Type': 'application/json'}
	});

	//todo 必要なapiを確認。 まずはfeedを指定して取ってきて、表示してみる。
	getFeed = (id) => {
		let params = new URLSearchParams({
			'id': id
		});

		let url = 'feed/get';
		api.post(url, $params)
			.then(res => {
				if (res.data.status === 1)  {
					resolve();
				} else {
					reject("get feed error");
				}
			});
	};

	getHello = (id) => {
		let url = 'hello';
		api.post(url, new URLSearchParams())
			.then(res => {
				if (res.data.status === 1)  {
					//何が返ってくる？
					resolve(res.data.str);
				} else {
					reject("get feed error");
				}
			});
	};

	// @computed get activeFeedCount() {
	// 	return this.feeds.reduce(
	// 		(sum, feed) => sum + (feed.completed ? 0 : 1),
	// 		0
	// 	)
	// }

	subscribeLocalstorageToStore() {
		reaction(
			() => this.toJS(),
			feeds => localStorage.setItem('mobx-react-feedmvc-feeds', JSON.stringify({ feeds }))
		);
	}

	@action
	addFeed (message) {
		this.feeds.push(new FeedModel(this, Utils.uuid(), message, 'hanako', 20190719));
	}

	toJS() {
		return this.feeds.map(feed => feed.toJS());
	}

	static fromJS(array) {
		const feedStore = new FeedStore();
		feedStore.feeds = array.map(item => FeedModel.fromJS(feedStore, item));
		return feedStore;
	}
}
