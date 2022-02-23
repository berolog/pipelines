#!/usr/bin/env bash

CODE=$(( $RANDOM % 4 + 0 ))

if [ $CODE -eq 0 ]; then
    echo "Vse norm, prodoljaem(Code: 0)"
else
    echo "Zakanchivaem...(Code: $CODE)"
    exit $CODE
fi
