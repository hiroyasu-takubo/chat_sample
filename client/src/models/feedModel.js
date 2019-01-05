import {observable} from 'mobx';
import { extendObservable } from 'mobx';

export default class FeedModel {
	store;
	id;
	@observable message;
	@observable userName;
	@observable registDate;

	constructor(store, id, message, userName, registDate) {
		this.store = store;
		this.id = id;
		this.message = message;
		this.userName = userName;
		this.registDate = registDate;

		extendObservable(this, {
			message: '',
			userName: '',
			registDate: '',
		})
	}

	destroy() {
		this.store.feeds.remove(this);
	}

	setMessage(message) {
		this.message = message;
	}

	setUserName(userName) {
		this.userName = userName;
	}

	toJS() {
		return {
			id: this.id,
			message: this.message,
			userName: this.userName,
			registDate: this.registDate
		};
	}

	static fromJS(store, object) {
		return new FeedModel(store, object.id, object.message, object.userName, object.registDate);
	}
}
