import './Send.css';
import React, { useEffect, useState } from 'react';

function Send({ isOpen, onSendMessage }) {
  const [message, setMessage] = useState('');
  const styles = {
    container: {
        maxWidth: '600px',
        margin: '0 auto',
        padding: '20px',
        border: '1px solid #ccc',
        borderRadius: '5px',
        boxShadow: '0 2px 5px rgba(0,0,0,0.1)',
    },
    messageList: {
        marginTop: '10px',
    },
    message: {
        padding: '10px',
        borderBottom: '1px solid #eee',
    },
};
  if (!isOpen) return null;
  function onSendMessage(message){
      //do stuff here!
      console.log(message);
  }
  const handleInputChange = (event) => {
    setMessage(event.target.value);
  };

  const handleSendMessage = () => {
    if (message.trim()) {
      onSendMessage(message);
      setMessage(''); // Clear the input after sending
    }
  };

  return (
    <div className="Send">

      <div className="Send-input">
        <input
          type="text"
          value={message}
          onChange={handleInputChange}
          placeholder="Type your message here..."
        />
        <button onClick={handleSendMessage}>Send</button>
      </div>
    </div>
  );
}

export default Send;