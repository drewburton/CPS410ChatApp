import './Session.css';
import User from '../User/User';

function Session({ isOpen }) {
  if (!isOpen) return null;

  return (
    <div className="Session">
      <header className="Session-header">
        <p>
          Edit <code>src/Session.js</code> and save to reload.
        </p>
      </header>

      <User />

    </div>
  );
}

export default Session;