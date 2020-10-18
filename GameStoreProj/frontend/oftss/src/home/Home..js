import React from "react";
import Layout from "../components/Layout";
import Carousel from 'react-bootstrap/Carousel'
import "./Home.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import {appConstants} from "../constants/constants";
import {Link} from "react-router-dom";

export const Home = () => {
    return (
        <Carousel className="container" style={{marginTop: '5%'}}>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://www.gaminginstincts.com/wp-content/uploads/2019/10/fortnite_adds_new_chapter_2_update_Gaming_Instincts_TV_Article_Website_Youtube_Thumbnail.jpgedited.jpg"
                    alt="First slide"
                />
                <Carousel.Caption>
                    <Link to={appConstants.videoGamesRoute}>
                    <button className="btn btn-danger">Shop Now</button>
                    </Link>
                    <h3>THE PERFECT SELECT</h3>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/most-popular-video-games-of-2020-1582141293.png"
                    alt="Third slide"
                />

                <Carousel.Caption>
                    <Link to={appConstants.videoGamesRoute}>
                        <button className="btn btn-danger">Shop Now</button>
                    </Link>
                    <h3>DON'T WAIT</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.fatherly.com/wp-content/uploads/2019/07/games-roundup.jpg?q=65&enable=upscale&w=600"
                    alt="Third slide"
                />

                <Carousel.Caption>
                    <Link to={appConstants.videoGamesRoute}>
                        <button className="btn btn-danger">Shop Now</button>
                    </Link>
                    <h3>ENTERTAIN YOURSELF</h3>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
    );
}

