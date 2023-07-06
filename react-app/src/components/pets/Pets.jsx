import React, { useState, useEffect } from "react";
import { findPets } from "../../services/PetServices";
import styles from "./Pets.module.css";

export const Pets = () => {
    const [pets, setPets] = useState([]);

    useEffect(() => {
      findPets()
            .then(({data}) => {
            setPets(data);
            });
    }, []);
  return (
    <>
        { pets.map(pet => 
        <div className={styles.pets}>
            <div>ID: {pet.id}</div>
            <div>Name: {pet.name} </div>
            <div>Age: {pet.age}</div>
        </div>) 
        }
    </>
  )
};
