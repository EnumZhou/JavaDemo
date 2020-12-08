import React,{Fragment} from 'react';
import Header from "../components/Header";
import PageHeader from "../components/PageHeader";
import PageAbout from "../components/About/page";
import Services from "../components/Services";
// import PricingTable from "../components/PricingTable";
// import Testimonial from "../components/Testimonials/home-two";
// import BrandLogo from "../components/BrandLogo";
import Funfact from "../components/Funfact";
import CallToAction from "../components/CallToAction";
import Footer from "../components/Footer";
import LoginRegister from "../components/LoginRegister";
import MobileMenu from "../components/MobileMenu";

import ServiceThumb from '../assets/img/about_demo.jpg'

const PageService = () => {
    return (
        <Fragment>
            <Header/>
            <PageHeader
                bgImg={require('../assets/img/page-header.jpg')}
                title="OUR SERVICES"
                content="Viswise always try to provide the best training services for Clients to grow up their Career very sharply and smoothly."
            />
            <PageAbout
                title={'Our Services'}
                heading="Provide best <br/> training services"
                thumb={ServiceThumb}
                content="<b>Viswise</b> always try to provide the best training services for Kids & Adults to grow up their Skills very sharply and smoothly.
                We voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."
            />
            <Services classes="sm-top"/>
            {/*<PricingTable/>*/}
            {/*<Testimonial/>*/}
            {/*<BrandLogo/>*/}
            <Funfact classes="sp-top"/>
            <CallToAction/>
            <Footer/>
            <LoginRegister/>
            <MobileMenu/>
        </Fragment>
    );
};

export default PageService;