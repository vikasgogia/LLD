# Parking Lot System

Parking lot system handles vehicles parking, payment collection 
and managing spaces efficiently.

_Note: The system handles different sorts of vehicles._

## Prerequisites

- Multiple slots of varying sizes.
- Multiple sorts of vehicles (car, bike, truck).
- Multiple payment methods.
- Each vehicle gets a parking ticket.
- Parking fee is calculated based on duration of stay and vehicle type.
- Pay before exiting.
- Slot is freed after exiting.

## Functional Requirements

- Multiple slots of varying sizes.
- Multiple sorts of vehicles (car, bike, truck).
- Dynamic fee calculation based on stay and vehicle type.
- Payment processing with multiple payment methods.
- Entry ticket issuance and exit validation.

_Note: Concurrent bookings are not handled as of now._

## Components

### Vehicle

1. `Vehicle` abstract class consisting of license plate, type.
2. Concrete class for `Bike`, `Car`, `Track` extending the Vehicle.

### Parking Lot

1. `ParkingLot` manager class for vehicle allocation and slot cleanups.
2. `ParkingSlot` class for slot type and is occupied or not.

### Payment

1. `PaymentStrategy` interface for different payment methods like card, cash.

## Design Patterns

- Strategy: payment methods and fare calculation.
- Factory: Vehicle creation.
- Singleton: Parking lot instantiation.
- Observer: Exit notifications to the user.
