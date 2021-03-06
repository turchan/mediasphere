import React, { Component } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { createMaterial } from "../util/APIUtils";

class AddContactComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id_material: this.props.match.params.id,
            title: '',
            description: '',
            location: '',
            deadline: '',
            id_sphere: null
        }

        this.onSubmit = this.onSubmit.bind(this);
    }

    onSubmit(values) {
        let material = {
            id_material: this.state.id_material,
            title: values.title,
            description: values.description,
            location: values.location,
            deadline: values.deadline,
            id_sphere: values.id_sphere
        }

        createMaterial(material, material.id_sphere)
            .then(() =>  this.props.history.push('/materials'));

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
                                        <Field className="form-control" type="text" name="id_material" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Title</label>
                                        <Field className="form-control" type="text" name="title" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Location</label>
                                        <Field className="form-control" type="text" name="location" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>DeadLine</label>
                                        <Field className="form-control" type="text" name="deadline" />
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