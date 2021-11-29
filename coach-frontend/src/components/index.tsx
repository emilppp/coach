import React from 'react';
import { makeStyles } from '@mui/styles';
import { Typography } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import logo from '../res/logo.png';

const useStyles = makeStyles((theme : any) => ({
        page: {
            height: '100vh',
            width: '100vw',
            overflow: 'hidden',
            background: 'linear-gradient(0deg, rgba(0,0,0,1) 0%, rgba(68,68,94,0) 57%, rgba(148,170,191,0) 100%)'
            // padding: theme.spacing(1),
        },
        content: {
            // margin: theme.spacing(1),
            padding: theme.spacing(3),
        },
        typography: {
            color: 'white',
            userSelect: 'none',
        },
        header: {
            height: 30,
            marginBottom: 25,
            paddingBottom: 15,
            display: 'flex',
            flexDirection: 'row',
            alignItems: 'center',
            backgroundColor: theme.palette.secondary.dark,
            padding: theme.spacing(3),
        },
        footer: {
            height: 50,
            position: 'absolute',
            bottom: 0,
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            width: '100%',
        },
        spacer: {
            display: 'flex',
            flexGrow: 1,
        },
        link: {
            color: 'white',
        },
        panel: {
            display: 'flex',
            flexDirection: 'column',
        },
        divider: {
            backgroundColor: 'white',
            margin: 25,
        },
        logo: {
            marginRight: 15,
            width: 24,
        }
}));

export const Page = (props : any) => {
    const classes = useStyles();
    return (
        <div className={classes.page}>
            <Header/>
            <div className={classes.content}>
                {props.children}</div>
                <Footer/>
            </div>
    );
};

export const Paragraph = (props: any) => {
    const classes = useStyles();

    return (
        <Typography variant={props.variant} style={props.style} className={classes.typography}>{props.children}</Typography>
    )
}

export const Spacer = (props: any) => {
        const classes = useStyles();

    return (
        <div 
        style={props.horizontal? {
            flexDirection: 'row'
        }: {
            flexDirection: 'column'

        }} 
        className={classes.spacer}/>
    )
}

export const Link = (props : any) => {
    const classes = useStyles();
    return (
        <RouterLink style={props.style} className={classes.link} to={props.to}>{props.children}</RouterLink>
    )
}
export const Header = (props: any) => {
    const classes = useStyles();

    return (
        <div className={classes.header}>
            <img className={classes.logo} src={logo} alt="logo"/>
            <Paragraph variant="h5">COACH</Paragraph>
            <Spacer horizontal/>
            <Paragraph variant="h6">Sign in</Paragraph>
            <Paragraph variant="h6" style={{marginLeft: 25}} >Register</Paragraph>
        </div>
    )
}

export const Footer = (props: any) => {
    const classes = useStyles();

    return (
        <div className={classes.footer}>
            <Paragraph variant="h7">Register</Paragraph>
        </div>
    )
}

export const Panel = (props: any) => {
    const classes = useStyles();
    return (
        <div style={props.style} className={classes.panel}>
            {props.children}
        </div>
    )
}

export const Divider = (props: any) => {
    const classes = useStyles();

    return (
        <div style={{...props.style, ...(props.horizontal? {width: '50%', height: '1px'}: {height: '50%', width: '1px'})}} className={classes.divider}/>
    )
}