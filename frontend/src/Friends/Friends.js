import './Friends.css';
import React, { useEffect, useState } from 'react';
function Friends() {
  const [friendresult, setfriendresult] = useState('');
  const [inputValue, setInputValue] = useState('');
  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };
  
  function addFriend(){
    //do friend bs...
        const response = fetch('http://localhost:8080/addfriend', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name: inputValue})},
        ).then(function(r){
          if (r.ok) {
          //stuff
          
          r.text().then(function(result){

          
          console.log("XX" +JSON.stringify(result));
          
          if(result=="Friend Added"){
            setfriendresult("Friend Added");
          }if(result=="You've already added that friend"){
            setfriendresult("You've already added that friend");
          }else if(result=="No friend found"){
            setfriendresult("No friend found");
          }else if(result=='That is you'){
            setfriendresult("That is you");
          }
        })
        }else{
          //damn
        }
      
        }).then(function(data) {
          // `data` is the parsed JSON data, not a Promise
          console.log(data);
      })};
  
  return (
    <div className="Friends">
      <header className="Friends-header">
        <p>
          Add friends: <input
        className="my-input"
        type="text"
        value={inputValue}
        onChange={handleInputChange}
      />
          <p className='friendaddresult'>{friendresult}</p>
          <button onClick={addFriend}>Add</button>
        </p>
      </header>
    </div>
  );
}

export default Friends;
