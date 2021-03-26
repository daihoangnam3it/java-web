import axios from 'axios';

import {
  USER_LOGIN_REQUEST,
  USER_LOGIN_SUCCESS,
  USER_LOGIN_FAIL,
  USER_LOGOUT,
  USER_REGISTER_REQUEST,
  USER_REGISTER_SUCCESS,
  USER_REGISTER_FAIL,
  USER_UPDATE_PROFILE_SUCCESS,
  USER_UPDATE_PROFILE_REQUEST,
  USER_UPDATE_PROFILE_FAIL,
  USER_DETAILS_FAIL,
  USER_DETAILS_SUCCESS,
  USER_DETAILS_REQUEST,
  USER_LIST_REQUEST,
  USER_LIST_SUCCESS,
  USER_LIST_FAIL,
  USER_LIST_RESET,
  USER_DELETE_REQUEST,
  USER_DELETE_SUCCESS,
  USER_DELETE_FAIL,
  USER_DELETE_RESET,
  USER_UPDATE_REQUEST,
  USER_UPDATE_SUCCESS,
  USER_UPDATE_FAIL,
  USER_UPDATE_RESET
} from '../constants/userConstant';

export const login = (email, password) => async (dispatch) => {
  try {
    dispatch({ type: USER_LOGIN_REQUEST });
    const config = {
      headers: {
        'Content-Type': 'application/json',
      },
    };
    // const { data } = await axios.post(
    //   `/api/users/login`,
    //   { email, password },
    //   config,
    // );
    const { data } = await axios.post(`https://javawebdoan.herokuapp.com/user/login`,{ email, password });
    if(!data.id){
     return  dispatch({
        type: USER_LOGIN_FAIL,
        // payload:error.response && error.response.data.msg
        payload:"Sai mật khẩu hoặc tài khoản",
      });
    }
    dispatch({
      type: USER_LOGIN_SUCCESS,
      payload: data,
    });
    localStorage.setItem('userInfo', JSON.stringify(data));
  } catch (error) {
    dispatch({
      type: USER_LOGIN_FAIL,
      // payload:error.response && error.response.data.msg
      payload: error.response && error.response.data.msg,
    });
  }
};

export const logout = () => async (dispatch) => {
  localStorage.removeItem('userInfo');
  dispatch({
    type: USER_LOGOUT,
  });
  dispatch({
    type:USER_LIST_RESET
  });
  dispatch({
    type:USER_DELETE_RESET
  })

};

export const register = (name, email, password) => async (dispatch) => {
  try {
    dispatch({ type: USER_REGISTER_REQUEST });
    // const { data } = await axios.post(`/api/users/register`, {
    //   name,
    //   email,
    //   password,
    // });
    const { data } = await axios.post(`https://javawebdoan.herokuapp.com/user/register`, {
      name,
      email,
      password,
    });
    dispatch({ type: USER_REGISTER_SUCCESS, payload: data });
    // dispatch({
    //   type: USER_LOGIN_SUCCESS,
    //   payload: data,
    // });
    localStorage.setItem('userInfo', JSON.stringify(data));
  } catch (error) {
    dispatch({
      type: USER_REGISTER_FAIL,
      // payload:error.response && error.response.data.msg
      payload: error.response && error.response.data.msg,
    });
  }
};

export const detailUser=(id) => async (dispatch,getState)=>{
  try {
    dispatch({type:USER_DETAILS_REQUEST});
    const {userLogin:{userInfo}}=getState()
    const { data } = await axios.get(`/users/`)
    const userDetail=data.filter(el=>el.id===id);
    console.log(userDetail);
    const profile=await axios.get(`/profile/${id}`)
    // console.log(data);
    const dataUser={
      ...userDetail[0],
      ...profile.data
    }
    dispatch({
      type:USER_DETAILS_SUCCESS,
      payload:dataUser
    })
  } catch (error) {
    dispatch({
      type: USER_DETAILS_FAIL,
      payload: error.response && error.response.data.msg,
    });
  }
}

export const updateProfile=(info)=>async (dispatch,getState)=>{
  try {
    dispatch({type:USER_UPDATE_PROFILE_REQUEST});
    const {userLogin:{userInfo}}=getState()
    // const config={
    //   headers:{
    //     'Authorization':userInfo.token
    //   }
    // }
    
    const {data}= await axios.put( `https://javawebdoan.herokuapp.com/user/update/${userInfo.id}`,info/*,config*/)
    dispatch({type:USER_UPDATE_PROFILE_SUCCESS})
  } catch (error) {
    dispatch({type:USER_UPDATE_PROFILE_FAIL,payload:error.response && error.response.data.msg})
  }
}



export const getListUser=()=>async (dispatch,getState)=>{
  try {
    dispatch({type:USER_LIST_REQUEST});
    const {userLogin:{userInfo}}=getState()
    const config={
      headers:{
        'Authorization':userInfo.token
      }
    }
    const {data}= await axios.get( `/users`)
    dispatch({type:USER_LIST_SUCCESS,payload:data})
  } catch (error) {
    dispatch({type:USER_LIST_FAIL,payload:error.response && error.response.data.msg})
  }
}

export const deleteUser=(id) => async (dispatch,getState)=>{
  try {
    dispatch({type:USER_DELETE_REQUEST});
    const {userLogin:{userInfo}}=getState()
    const config={
      headers:{
        'Authorization':userInfo.token
      }
    }
    const {data} = await axios.delete(`https://javawebdoan.herokuapp.com/user/delete/${id}`,config)
    dispatch({
      type:USER_DELETE_SUCCESS,
      
    })
  } catch (error) {
    dispatch({
      type: USER_DELETE_FAIL,
      payload: error.response && error.response.data.msg,
    });
  }
}

export const getUserDetails = (id) => async (dispatch, getState) => {
  try {
    dispatch({
      type: USER_DETAILS_REQUEST,
    })

    const {
      userLogin: { userInfo },
    } = getState()

    // const config = {
    //   headers: {
    //     'Authorization':userInfo.token
    //   },
    // }
    
    const { data } = await axios.get(`/users/`)
    const userDetail=data.filter(el=>el.id===id);
    console.log(userDetail);
    const profile=await axios.get(`/profile/${id}`)
    // console.log(data);
    const dataUser={
      ...userDetail[0],
      ...profile.data
    }
    dispatch({
      type: USER_DETAILS_SUCCESS,
      payload: dataUser,
    })
  } catch (error) {
    dispatch({
      type: USER_DETAILS_FAIL,
      payload: error.response && error.response.data.msg,
    });
  }
}


export const updateUserWithAdmin=(user)=>async (dispatch,getState)=>{
  try {
    dispatch({type:USER_UPDATE_REQUEST});
    const {userLogin:{userInfo}}=getState()
    console.log(user);
    const {data}= await axios.put( `http://localhost:6039/user/update/${user.id}`,user)
    dispatch({type:USER_UPDATE_SUCCESS,payload:data})
    dispatch({
      type:USER_DETAILS_SUCCESS,
      payload:data
    })
  } catch (error) {
    dispatch({type:USER_LIST_FAIL,payload:error.response && error.response.data.msg})
  }
}
