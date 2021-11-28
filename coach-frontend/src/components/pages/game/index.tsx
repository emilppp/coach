import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { Link } from 'react-router-dom';

interface Game {
    readonly id: number;
    readonly name: string;
    readonly date: string;
}

const games: Game[] = [1, 2, 3, 4, 5].map((i: number) => {
    return {
        id: i,
        name: `Test game ${i}`,
        date: new Date().toDateString(),
    }
})

export const GameListPage = (props: any) => {
    const gameItems = games.map(game => {
        return <div key={game.id}>
            <p>{game.id}</p>
            <p>{game.date}</p>
            <p>{game.name}</p>
            <Link to={`/games/${game.id}`}>View details</Link>
        </div>
    })

    return (
        <div>
            {gameItems}
        </div>
    )
}

export const GameDetailsPage = (props: any) => {
    const { id: number } = useParams();
    const [game, setGame] = useState(null);

    useEffect(() => {
        const newGame: { id: number, name: string, date: Date } = games.find(g => g.id === id);
        setGame(newGame);
    });

    return (
        <div>
            <p>{id}</p>
            <p>{id}</p>
            <p>{id}</p>
            <p>{id}</p>
        </div>
    )
}