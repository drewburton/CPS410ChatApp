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
  async function onSendMessage(message) {
    //do stuff here!
    console.log(message);
    try {//http://localhost:3000/savechat
      const response = await fetch('https://cps410chatappbackenddev.onrender.com/', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          "text": message,
          "user": "test",
          "timestamp": new Date()
        })
      });

      if (response.ok) {
        console.log('Success');
      } else {
        console.error('Error:', response.statusText);
      }
    } catch (error) {
      console.error('Error:', error);
    }
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
        <button className='sendButton' onClick={handleSendMessage}>Send</button>
      </div>
    </div>
  );
}

export default Send;