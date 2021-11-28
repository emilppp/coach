import React from 'react';
import { Link } from 'react-router-dom';

export const HomePage = (props: any) => {
    return (
        <div>
            <p>home</p>
            <Link to="/games">see games</Link>
        </div>
    )
}