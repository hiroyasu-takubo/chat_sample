import React from 'react';
import PropTypes from 'prop-types';
import {observer} from 'mobx-react';
import {observable, expr} from 'mobx';

@observer
export default class FeedItem extends React.Component {
	@observable editMessage = "";

	render() {
		const {feed} = this.props;
		return (
			<li>
				<div className="view">
					<label onDoubleClick={this.handleEdit}>
						{feed.userName}
						{feed.message}
						{feed.registDate}
					</label>
					<button className="destroy" onClick={this.handleDestroy} />
				</div>
				<input
					ref="editField"
					className="edit"
					value={this.editMessage}
					onBlur={this.handleSubmit}
					onChange={this.handleChange}
					onKeyDown={this.handleKeyDown}
				/>
			</li>
		);
	}

	handleSubmit = (event) => {
		const val = this.editMessage.trim();
		if (val) {
			this.props.feed.setMessage(val);
			this.editMessage = val;
		} else {
			this.handleDestroy();
		}
	};

	handleDestroy = () => {
		this.props.feed.destroy();
	};

	handleEdit = () => {
		const feed = this.props.feed;
		this.editMessage = feed.message;
	};

	handleChange = (event) => {
		this.editMessage = event.target.value;
	};
}

FeedItem.propTypes = {
	feed: PropTypes.object.isRequired
};
