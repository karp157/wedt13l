#!/bin/sh

curl -XDELETE http://$1:9200/_all
curl -XPUT http://$1:9200/twitter
curl -XPUT http://$1:9200/twitter/post/_mapping --data @mapping.json

curl -XPOST $1:9200/twitter/_close
curl -XPUT $1:9200/twitter/_settings --data @analyzer.json 
curl -XPOST $1:9200/twitter/_open
