import './App.css';
import { BrowserRouter } from 'react-router-dom';
import { Router } from './routes';
import { createTheme, ThemeProvider } from '@mui/material';
import { useEffect } from 'react';

const theme = createTheme({
  palette: {
    primary: {
      main: '#2C363F',
    },
    secondary: {
      dark: '#181A1C',
      main: '#597B86',
    },
  },
  spacing: 8,
});

function App() {
    useEffect(() => {
    document.body.style.backgroundColor = theme.palette.primary.main;
  }, []);

  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter>
        <Router />
      </BrowserRouter>
    </ThemeProvider> 
  );
}

export default App;
