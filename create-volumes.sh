#!/bin/sh

# Create volumes if they doesn't exist
docker volume create esedm-db-data || true
