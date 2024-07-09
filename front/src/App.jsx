import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import { Routes, Route, Navigate } from 'react-router-dom';
import LoginPage from './pages/LoginPage/LoginPage';
import RegisterPage from './pages/RegisterPage/RegisterPage';
import RecipesPage from './pages/RecipesPage/RecipesPage';
import { UserProvider } from './Context/UserContext/UserContext';
import ProtectedRoute from './Components/ProtectedRoute/ProtectedRoute';
import NotFoundPage from './pages/NotFoundPage/NotFoundPage';

function App() {
  return (
    <>
      <ToastContainer autoClose={800} position='top-center' />
      <UserProvider>
        <Header />
        <Routes>
          <Route path='/' element={<Navigate to='/register' />} />
          <Route path='/register' element={<RegisterPage />} />
          <Route path='/login' element={<LoginPage />} />
          <Route
            path='/recipes'
            element={
              <ProtectedRoute>
                <RecipesPage />
              </ProtectedRoute>
            }
          />
          <Route path='*' element={<NotFoundPage />} />
        </Routes>
      </UserProvider>
      <Footer />
    </>
  );
}

export default App;
