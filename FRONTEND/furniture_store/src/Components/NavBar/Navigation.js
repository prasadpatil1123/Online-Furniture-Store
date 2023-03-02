import { MenuData } from "./MenuData";
import './NavBarStyles.css'
function ColorSchemesExample() {
  return (
    
      <nav className="NavbarItems">
        <h1 className="logo">OFS</h1>
        <ul className="nav-menu">
        {MenuData.map((item, index)=>{return (
          <li key={index}>
            <a href={item.url}
            className={item.cName}>
              {item.title}
            </a>
          
          </li>
        );
        })}
        </ul>
</nav>
);
}


export default ColorSchemesExample; 