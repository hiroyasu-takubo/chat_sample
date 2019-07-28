import 'todomvc-common';
import FeedStore from './stores/FeedStore';
import FeedApp from './component/FeedApp.js';
import React from 'react';
import ReactDOM from 'react-dom';

const initialState = window.initialState && JSON.parse(window.initialState) || {};

var feedStore = FeedStore.fromJS(initialState.feeds || []);
// var viewStore = new ViewStore();

feedStore.subscribeServerToStore();

ReactDOM.render(
	<FeedApp feedStore={feedStore}/>,
	document.getElementById('feedapp')
);

if (module.hot) {
	module.hot.accept('./components/feedApp', () => {
		var NewFeedApp = require('./components/FeedApp').default;
		ReactDOM.render(
			<NewFeedApp feedStore={feedStore} />,
			document.getElementById('feedapp')
		);
	});
}

