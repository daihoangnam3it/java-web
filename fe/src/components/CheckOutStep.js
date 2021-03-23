import React from 'react'
import { Nav } from 'react-bootstrap'
import {LinkContainer} from 'react-router-bootstrap'
const CheckOutStep = ({step1,step2,step3,step4}) => {
  return (
    <Nav className='justify-content-center mb4'>
      <Nav.Item>
        {step1 ? (<LinkContainer to='/login'>
            <Nav.Link>Đăng nhập</Nav.Link>
        </LinkContainer>):<Nav.Link disabled>Đăng nhập</Nav.Link>}
      </Nav.Item>
      <Nav.Item>
        {step2 ? (<LinkContainer to='/shipping'>
            <Nav.Link>Shipping</Nav.Link>
        </LinkContainer>):<Nav.Link disabled>Shipping</Nav.Link>}
      </Nav.Item>
      <Nav.Item>
        {step3 ? (<LinkContainer to='/payment'>
            <Nav.Link>Thanh toán</Nav.Link>
        </LinkContainer>):<Nav.Link disabled>Thanh toán</Nav.Link>}
      </Nav.Item>
      <Nav.Item>
        {step4 ? (<LinkContainer to='/placeorder'>
            <Nav.Link>Đặt hàng</Nav.Link>
        </LinkContainer>):<Nav.Link disabled>Đặt hàng</Nav.Link>}
      </Nav.Item>
    </Nav>
  )
}

export default CheckOutStep
