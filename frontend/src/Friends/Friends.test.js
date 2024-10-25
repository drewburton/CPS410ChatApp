import { render, screen, configure, fireEvent,waitFor } from '@testing-library/react';
import Friends from './Friends';
import {act} from 'react';
test('friends', async function() {
    
  const element = render(<Friends />);
  const container=element.container;
  const input = container.getElementsByClassName('my-input')[0];

  fireEvent.change(input, { target: { value: "Arjay lalonde" } });
  fireEvent.click(screen.getByText('Add'))
  expect(true)
  await waitFor(() => {
    return Promise.race([
      container.findByText('Friend Added'),
      container.findByText('No friend found'),
      container.findByText('That is you'),
    ]);
  }, { timeout: 5000 });
});
