import { createStore} from "redux";
import reducer1 from "./reducer1";

const initialSt = {loggedin:false}; //data

const mystore1 = createStore(reducer1,initialSt)

export default mystore1;