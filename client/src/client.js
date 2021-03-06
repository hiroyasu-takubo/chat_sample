import FeedStore from './stores/FeedStore';
import FeedApp from './component/FeedApp.js';
import ReactDOM from 'react-dom';

const initialState = window.initialState && JSON.parse(window.initialState) || {};

var feedStore = FeedStore.fromJS(initialState.feeds || []);

feedStore.subscribeServerToStore();

ReactDOM.render(
	<FeedApp feedStore={feedStore}/>,
	document.getElementById('feedapp')
);

if (module.hot) {
	module.hot.accept('./component/FeedApp', () => {
		var NewFeedApp = require('./component/FeedApp').default;
		ReactDOM.render(
			<NewFeedApp feedStore={feedStore} />,
			document.getElementById('feedapp')
		);
	});
}

