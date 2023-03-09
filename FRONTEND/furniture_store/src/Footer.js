import React from 'react';
import './Footer.css';

function Footer() {
  return (
    <footer className="footer">
      <div className="container">
        <div className="row">
          <div className="col-md-4">
            <h4>About Us</h4>
            <p>We are an online furniture store that specializes in unique, high-quality pieces for every room in your home.</p>
          </div>
          <div className="col-md-4">
            <h4>Contact Us</h4>
            <p>1234 Main St.</p>
            <p>Karad, Satara 12345</p>
            <p>Phone: 724-9600-555</p>
            <p>Email: info@furniturestore.com</p>
          </div>
          <div className="col-md-4">
            <h4>Connect with Us</h4>
            <ul className="social-links">
              <li><a href="#"><i className="fa fa-facebook"></i></a></li>
              <li><a href="#"><i className="fa fa-twitter"></i></a></li>
              <li><a href="#"><i className="fa fa-instagram"></i></a></li>
              <li><a href="#"><i className="fa fa-pinterest"></i></a></li>
            </ul>
          </div>
        </div>
        <div className="row">
          <div className="col-md-12">
            <hr className="footer-divider" />
            <p className="text-center">© 2023 Furniture Store. All rights reserved.</p>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
