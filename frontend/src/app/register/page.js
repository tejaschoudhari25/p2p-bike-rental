"use client";

import { useState } from "react";
import { registerUser } from "@/services/authService";

export default function RegisterPage() {

    const [formData, setFormData] = useState({
        email: "",
        password: "",
        firstName: "",
        lastName: "",
        role: "USER"
    });

    const [message, setMessage] = useState("");

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await registerUser(formData);
            setMessage(response);
        } catch (error) {
            setMessage(
                error.response?.data || "Registration failed"
            );
        }
    };

    return (
        <div className="min-h-screen flex items-center justify-center">

            <form
                onSubmit={handleSubmit}
                className="w-full max-w-md space-y-4 p-6 border rounded-lg"
            >

                <h1 className="text-2xl font-bold">
                    Create Account
                </h1>

                <input
                    type="text"
                    name="firstName"
                    placeholder="First Name"
                    value={formData.firstName}
                    onChange={handleChange}
                    className="w-full border p-2 rounded"
                />

                <input
                    type="text"
                    name="lastName"
                    placeholder="Last Name"
                    value={formData.lastName}
                    onChange={handleChange}
                    className="w-full border p-2 rounded"
                />

                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={formData.email}
                    onChange={handleChange}
                    className="w-full border p-2 rounded"
                />

                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={formData.password}
                    onChange={handleChange}
                    className="w-full border p-2 rounded"
                />

                <select
                    name="role"
                    value={formData.role}
                    onChange={handleChange}
                    className="w-full border p-2 rounded"
                >
                    <option value="USER">User</option>
                    <option value="OWNER">Owner</option>
                </select>

                <button
                    type="submit"
                    className="w-full bg-blue-600 text-white p-2 rounded"
                >
                    Register
                </button>

                {message && (
                    <p className="text-center">
                        {message}
                    </p>
                )}

            </form>

        </div>
    );
}