import React from 'react';
import { Routes, Route, useMatch } from 'react-router-dom'
import { HomePage, GameDetailsPage, GameListPage } from '../components/pages';

export const Router = (props) => {
    return (
        <Routes>
            <Route path="/" exact element={<HomePage />} />
            <Route path="/games" exact element={<GameListPage />} />
            <Route path="/games/:id" exact element={<GameDetailsPage />} />
        </Routes >
    );
}