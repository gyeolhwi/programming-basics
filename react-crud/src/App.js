import { Global } from '@emotion/react';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import MainConatiner from './components/MainContainer/MainConatiner';
import MainLayout from './components/MainLayout/MainLayout';
import Sidebar from './components/Sidebar/Sidebar';
import DeletePage from './pages/basic/DeletePage';
import GetPage from './pages/basic/GetPage';
import PostPage from './pages/basic/PostPage';
import PostPage2 from './pages/basic/PostPage2';
import PutPage from './pages/basic/PutPage';
import { reset } from './styles/global';
import PromisePage from './pages/basic/PromisePage';
import RegisterSizePage from './pages/basic/RegisterSizePage';
import ComputerPage from './pages/basic/ComputerPage';

function App() {
  return (
    <>
      <Global styles={reset} />
      {/* 컨트롤러영역 */}
      <MainLayout>
        <Sidebar />
        <MainConatiner>
          <Routes>
            <Route path='/async/basic/post' element={<PostPage />} />
            <Route path='/async/basic/post2' element={<PostPage2 />} />
            <Route path='/async/basic/get' element={<GetPage />} />
            <Route path='/async/basic/put' element={<PutPage />} />
            <Route path='/async/basic/delete' element={<DeletePage />} />
            <Route path='/async/basic/promise' element={<PromisePage />} />
            <Route path='/async/basic/size/register' element={<RegisterSizePage/>}/>
            <Route path='/computer' element={<ComputerPage/>}/>

          </Routes>
        </MainConatiner>
      </MainLayout>
    </>
  )
}
export default App;
