import React from 'react';
import PropTypes from 'prop-types';
import {observer} from 'mobx-react';

import FeedOverview from './FeedOverview';

import DevTool from 'mobx-react-devtools';

@observer
export default class FeedApp extends React.Component {
	render() {
		const {feedStore} = this.props;
		return (
			<div>
				<DevTool />
				<header className="header">
					<h1>feeds</h1>
				</header>
				<FeedOverview feedStore={feedStore} />
			</div>
		);
	}

	componentDidMount() {
		if (__CLIENT__) {
			var { Router } = require('director/build/director');

			var router = Router({
				'/': 'all'
			});
			router.init('/');
		}
	}
	// componentDidMount() {
	// 	if (__CLIENT__) {
	// 		var { Router } = require('director/build/director');
	// 		var viewStore = this.props.viewStore;
	// 		var router = Router({
	// 			'/': function() { viewStore.todoFilter = ALL_TODOS; },
	// 			'/active': function() { viewStore.todoFilter = ACTIVE_TODOS; },
	// 			'/completed': function() { viewStore.todoFilter = COMPLETED_TODOS; }
	// 		});
	// 		router.init('/');
	// 	}
	// }
}

FeedApp.propTypes = {
	feedStore: PropTypes.object.isRequired
};
