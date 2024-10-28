import './Friends.css';
import React, { useEffect, useState } from 'react';
function Friends() {
  const [friendresult, setfriendresult] = useState('');

  function addFriend(friendName){
    //do friend bs...
        const response = fetch('https://cps410chatapp.onrender.com/addfriend', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: {name:friendName}},
        ).then(function(result){
          //stuff
          if(result.json().result=="Friend Added"){
            setfriendresult("Friend Added");
          }if(result.json().result=="You've already added that friend"){
            setfriendresult("You've already added that friend");
          }else if(result.json().result=="No friend found"){
            setfriendresult("No friend found");
          }else if(result.json().result=='That is you'){
            setfriendresult("That is you");
          }
        })};
  
  return (
    <div className="Friends">
      <header className="Friends-header">
        <p>
          Add friends: <input className="my-input" type="text"></input>
          <p className='friendaddresult'>{friendresult}</p>
          <button onClick={addFriend}>Add</button>
        </p>
      </header>
    </div>
  );
}

export default Friends;
