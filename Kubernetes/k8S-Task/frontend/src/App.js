import React, { useEffect, useState } from 'react';

function App() {
  const [msg, setMsg] = useState("Loading...");

  useEffect(() => {
    fetch(`${process.env.REACT_APP_API_URL}/lucky-number`)
      .then(res => res.json())
      .then(data => {
        const containerId = window.CONTAINER_ID || "unknown";
        setMsg(`Lucky number is ${data.luckyNumber}, from container: ${containerId}`);
      });
  }, []);

  return <h1>{msg}</h1>;
}

export default App;
