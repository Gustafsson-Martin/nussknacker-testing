from typing import Union
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from fastapi.openapi.utils import get_openapi

class Customer(BaseModel):
    id: int

class CustomerInfo(BaseModel):
    income: int
    pd: float

customers = {
    0: CustomerInfo(income=10000, pd=0.00),
    1: CustomerInfo(income=20000, pd=0.01),
    2: CustomerInfo(income=10000, pd=0.02),
    3: CustomerInfo(income=20000, pd=0.03),
}

app = FastAPI()

@app.get("/customer", response_model=Customer)
async def customer() -> Customer:
    return Customer(id=1)

@app.post("/UCRequest", response_model=CustomerInfo)
async def UCRequest(customer: Customer) -> CustomerInfo:
    try:
        return customers[customer.id]
    except KeyError:
        raise HTTPException(status_code=404, detail="Customer not found")