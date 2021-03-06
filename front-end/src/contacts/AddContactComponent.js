import React, { Component } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { createContact } from "../util/APIUtils";

class AddContactComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id_contact: this.props.match.params.id,
            name: '',
            surname: '',
            information: '',
            email: '',
            phone: '',
            workplace: '',
            position: '',
            location: '',
            country: '',
            city: '',
            price: null,
            id_sphere: null
        }

        this.onSubmit = this.onSubmit.bind(this);
    }

    onSubmit(values) {
        let contact = {
            id_contact: this.state.id_contact,
            name: values.name,
            surname: values.surname,
            information: values.information,
            email: values.email,
            phone: values.phone,
            workplace: values.workplace,
            position: values.position,
            location: values.location,
            country: values.country,
            city: values.city,
            price: values.price,
            id_sphere: values.id_sphere
        }

        createContact(contact, contact.id_sphere)
            .then(() =>  this.props.history.push('/contacts'));

        console.log(values);
    }

    render() {
        return (
            <div>
                <h3>New Contact</h3>
                <div className="container">
                    <Formik
                        enableReinitialize={true} 
                        initialValues={this.state}
                        onSubmit={this.onSubmit}
                    >
                        {
                            (props) => (
                                <Form>
                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id_contact" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Name</label>
                                        <Field className="form-control" type="text" name="name" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>SurName</label>
                                        <Field className="form-control" type="text" name="surname" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>information</label>
                                        <Field className="form-control" type="text" name="information" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Email</label>
                                        <Field className="form-control" type="text" name="email" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Phone</label>
                                        <Field className="form-control" type="text" name="phone" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Workplace</label>
                                        <Field className="form-control" type="text" name="workplace" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Position</label>
                                        <Field className="form-control" type="text" name="position" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Location</label>
                                        <Field className="form-control" type="text" name="location" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Country</label>
                                        <Field className="form-control" type="text" name="country" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>City</label>
                                        <Field className="form-control" type="text" name="city" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Price</label>
                                        <Field className="form-control" type="text" name="price" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <Field className="form-control" type="text" name="id_user" hidden />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Sphere</label>
                                        <Field className="form-control" type="text" name="id_sphere" />
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            </div>
        )
    }
}

export default AddContactComponent;