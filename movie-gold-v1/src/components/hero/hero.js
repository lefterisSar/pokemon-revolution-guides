import React from "react";
import Carousel from 'react-material-ui-carousel';
import {Paper} from "@mui/material";
import './hero.css'


const Hero = ({movies}) => {
    return (
        <div>
            <Carousel>
                {
                    movies.map((movie)=> {
                        return (
                            <div key={movie.id}>
                                <Paper>
                                    <div className='movie-card-container'>
                                        <div className='movie-card'>
                                            <div className="movie=poster">
                                                <img src = {movie.poster} alt=""/>
                                            </div>
                                            <div className='movie-title'>
                                                <h4>{movie.title}</h4>
                                            </div>
                                        </div>
                                    </div>
                                </Paper>
                            </div>
                        )
                    })
                }
            </Carousel>
        </div>
    )
}

export default Hero