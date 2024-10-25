import './Friends.css';

function Friends() {


  function addFriend(friendName){
    //do friend bs...
        const response = fetch('https://cps410chatapp.onrender.com/addfriend', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            body: {name:friendName}},
        ).then(function(result){
          //stuff
        })};
  
  return (
    <div className="Friends">
      <header className="Friends-header">
        <p>
          Add friends: <input className="my-input" type="text"></input>
          <button >Add</button>
        </p>
      </header>
    </div>
  );
}

export default Friends;
