import { makeStyles } from '@mui/styles';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { useNavigate } from 'react-router-dom';
import { Paragraph, Page, Divider, Spacer} from '../..';
import mapThumbnail from '../../../res/map_thumbnail.png';
import agents from '../../../data/agents.json';
import maps from '../../../data/maps.json';

const axios = require('axios');

interface Round {
    readonly round: number;
    readonly description: string;
}

interface Game {
    readonly id: number;
    readonly date: string;
    readonly map: string;
    readonly rounds: Round[];
    readonly teamOneAgents: string[];
    readonly teamTwoAgents: string[];
}

const useStyles = makeStyles((theme : any) => ({
        gameCard: {
            backgroundColor: theme.palette.secondary.main,
            margin: theme.spacing(1),
            padding: theme.spacing(2),
            borderRadius: 5,
            "&:hover": {
                cursor: 'pointer',
            },
        },
        gameList: {
            width: 800,
        },
        layout: {
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
        },
        overview: {
            display: 'flex',
            flexDirection: 'row',
            height: 200,
            marginTop: 25,
        },
        teamOverview: {
            width: 300,
            display: 'flex',
            flexDirection: 'column',
        },
        minimap: {
            borderStyle: 'solid',
            borderWidth: '1px',
            borderColor: 'white',
            width: 200,
            marginLeft: 25,
            marginRight: 25,
            backgroundColor: theme.palette.secondary.dark,
        },
        players: {
            display: 'flex',
            flexDirection: 'row',
        },
        player: {
            borderStyle: 'solid',
            borderWidth: '1px',
            borderColor: 'white',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            width: 75,
            height: 75,
            backgroundColor: theme.palette.secondary.dark,
            margin: 3,
        }
}));

export const GameListPage = (props: any) => {
    const navigate = useNavigate();
    const classes = useStyles();
    const [games, setGames] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/games')
        .then((response: any) => {
            setGames(response.data);
        })
        .then((error: any) => {
            console.log(error);
        });
    }, []);


    const gameItems = games.map((game: Game) => {
        return <div 
        className={classes.gameCard} 
        key={game.id}
        onClick={() => navigate(`/games/${game.id}`)}
        >
            <Paragraph variant="h5">{game.id}</Paragraph>
        </div>
    })

    return (
        <Page>
            <Paragraph variant="h3">Upcoming games</Paragraph>
            <div className={classes.gameList}>
                {gameItems}
            </div>
        </Page>
    )
}

const TeamLayout = (props: any) => {
    const { team } = props;
     const classes = useStyles();

     const playerItems = team.map((player: any) => {
         const image = (agents as any)[player].image;
         const img = require(`../../../res/agents/${image}`);
         return (
             <div className={classes.player}>
                <img style={{width: '100%'}} src={img.default} alt="player">
                </img>
                {/* <Paragraph variant="body">{player}</Paragraph> */}
             </div>
         )
     })

    return (
        <div style={props.style} className={classes.teamOverview}>
            <Paragraph variant="h7">Lorem Ipsum</Paragraph>
            <Spacer vertical/>
            <div className={classes.players}>
                {playerItems}
            </div>
        </div>

    );
}

export const GameDetailsPage = (props: any) => {
    const { id } = useParams();
    const [game, setGame] = useState<Game | undefined>(undefined);
    const classes = useStyles();
    useEffect(() => {
            axios.get(`http://localhost:8080/games/${id}`)
            .then((response: any)=> {
                console.log(response.data);
                setGame(response.data)
            })
            .catch((error: any) => {
                console.log(error);
            });
    }, []);

    if(!game) return <></>;

    const roundItems = game.rounds.map(round => {
        return (
            <Paragraph variant="h6">{`Round ${round.round} - ${round.description}`}</Paragraph>
        )
    })

    var map = mapThumbnail;
    if(game.map) {
        const mapImage = (maps as any)[game.map].image;
        map = require(`../../../res/maps/${mapImage}`).default;
    }


    return (
        <Page>
            <div className={classes.layout}>
                {/* <Paragraph variant="h6">{`${teams[0].name} v. ${teams[1].name}`}</Paragraph> */}
                <div className={classes.overview}>
                    <TeamLayout style={{alignItems: 'flex-end'}} team={game.teamOneAgents}/>
                    <img className={classes.minimap} src={map} alt="map thumbnail"/>
                    <TeamLayout style={{alignItems: 'flex-start'}} team={game.teamTwoAgents}/>
                </div>
                <Divider horizontal/>
                <Paragraph variant="h2">Details</Paragraph>
            </div>
        </Page>
    )
}