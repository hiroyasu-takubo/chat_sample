import React from 'react';
import ReactDOM, {render} from 'react-dom';
import './index.css';
import { observable, action } from "mobx";
import { observer } from "mobx-react";
import { extendObservable } from 'mobx';
import DevTools from "mobx-react-devtools";

class feedState {
	constructor() {
		extendObservable(this, {
			id: '',
			message: '',
			userName: '',
			registDate: '',
		})
	}

	// @action.bound
	clear() {
		this.id = 0;
		this.message = "";
		this.username = "";
		this.registDate = 0;
	}
}

const feed = observer(({feedState}) =>
	<div className="feed" onClick={feedState.clear}>
	<div>{feedState.id}</div>
	<div>{feedState.message}</div>
	<div>{feedState.username}</div>
	<div>{feedState.registDate}</div>
	</div>
)

render(
<div>
<feed appState={new feedState()} />
<DevTools />
</div>,
document.getElementById("root")
);


//sample
// class Board extends React.Component {
// 	renderSquare(i) {
// 		return (
// 			<Square
// 				value={this.props.squares[i]}
// 				onClick={() => this.props.onClick(i)}
// 			/>
// 		);
// 	}
//
// 	render() {
// 		return (
// 			<div>
// 				<div className="board-row">
// 					{this.renderSquare(0)}
// 					{this.renderSquare(1)}
// 					{this.renderSquare(2)}
// 				</div>
// 				<div className="board-row">
// 					{this.renderSquare(3)}
// 					{this.renderSquare(4)}
// 					{this.renderSquare(5)}
// 				</div>
// 				<div className="board-row">
// 					{this.renderSquare(6)}
// 					{this.renderSquare(7)}
// 					{this.renderSquare(8)}
// 				</div>
// 			</div>
// 		);
// 	}
// }

// class Hello extends React.Component {
// 	render(){
// 		return(
// 			<div class Name="commentForm">
// 				Hello, world!
// 			</div>
// 		);
// 	}
// }


// class Feed extends React.Component {
//
// 	render() {
// 		return(
// 			<div className="feed">
// 				<div>{this.props.id}</div>
// 				<div>{this.props.message}</div>
// 				<div>{this.props.username}</div>
// 				<div>{this.props.registDate}</div>
// 			</div>
// 		);
// 	}
// }

// class feedList extends React.Component {
//
// }

// class AppState {
// @observable timer = 0;
//
// 	constructor() {
// 		setInterval(() => {
// 			this.timer += 1;
// 		}, 1000);
// 	}
//
// @action.bound
// 	reset() {
// 		this.timer = 0;
// 	}
// }
//
// const TimerView = observer(({ appState }) => (
// 	<button onClick={appState.reset}>Seconds passed: {appState.timer}</button>
// ));
//
// render(
// 	<div>
// 		<TimerView appState={new AppState()} />
// 		<DevTools />
// 	</div>,
// 	document.getElementById("root")
// );