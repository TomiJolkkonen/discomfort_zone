import React from 'react';
import PropTypes from 'prop-types';

const Notification = ({ children }) => (
  <div className="notification">
    {children}
  </div>
);

Notification.propTypes = {
  children: PropTypes.node.isRequired,
};

export default Notification;