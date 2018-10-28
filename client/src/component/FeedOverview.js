import React from 'react';
import PropTypes from 'prop-types';
import {observer} from 'mobx-react';

import FeedItem from './FeedItem';

@observer
export default class FeedOverview extends React.Component {
	render() {
		const {feedStore} = this.props;
		if (feedStore.feeds.length === 0)
			return null;
		return <section className="main">
			<ul className="feed-list">
				{this.feeds.map(feed =>
					<FeedItem key={feed.id} feed={feed} />
				)}
			</ul>
		</section>
	}
}

FeedOverview.propTypes = {
	feedStore: PropTypes.object.isRequired
};