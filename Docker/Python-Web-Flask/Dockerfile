# Use the official Python image
FROM python:3.9-slim

# Set the working directory
WORKDIR /app

# Copy the requirements file into the container
COPY requirements.txt .

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Install curl
RUN apt-get update && apt-get install -y curl

# Copy the application code into the container
COPY . .

# Expose the port the app runs on
EXPOSE 5000

# Define the command to run the application
CMD ["python", "app.py"]


# docker build -t image_name .
# docker run -p 5000:5000 -v .:/app image_name


# FROM python:3.9.6-slim-buster

# WORKDIR /app

# ADD requirements.txt .

# RUN pip3 install -r requirements.txt

# COPY app.py .

# ENV version=1.0.0

# EXPOSE 5000

# CMD ["python3", "app.py"]
