import React, { Component } from "react";
import { Link } from "react-router-dom";

class Navbar extends Component {
    render(){
        return(
            <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
            <div className="container">
                    <Link to="/" className="navbar-brand">
                        Backlog App
                    </Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                    <span className="navbar-toggler-icon" />
                </button>
            </div>
        </nav>  )
    }    
}
export default Navbar;