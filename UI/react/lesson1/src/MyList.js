import React, { Component } from 'react';

export default class MyList extends Component {
  constructor(props) {
    super(props);
    this.onClick = this.onClick.bind(this);
  }

  onClick(id) {
    const item = this.props.items.find((x) => x.id === id);
    const name = item ? item.name : 'Unknown';
    console.log('clicked', `"${name}"`);
  }

  render() {
    return (
      <div>
        <h2>Clickable Items</h2>
        <ul>
          {this.props.items.map(({ id, name }) => (
            <li
              key={id}
              onClick={this.onClick.bind(null, id)}
              style={{ cursor: 'pointer', marginBottom: '6px' }}
            >
              {name}
            </li>
          ))}
        </ul>
        <p>Open browser console to see clicked item logs.</p>
      </div>
    );
  }
}