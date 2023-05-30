#!/bin/bash

# Go to the main directory
cd ..

# Remove current bin and build directories
# rm -rf bin build

# Run gradle clean build
# ./gradlew clean build

# Copy the war file to the current directory
cp build/libs/web-dashboard-api-0.0.1.war .

# Rename the generated war file to dashboardapi.war
mv web-dashboard-api-0.0.1.war dashboardapi.war

# Message For User
echo "Build Successful"
