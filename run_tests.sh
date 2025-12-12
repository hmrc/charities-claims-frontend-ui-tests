#!/usr/bin/env bash

BROWSER=$1
ENVIRONMENT=$2
sbt scalafmtAll scalafmtCheckAll scalafmtSbtCheck clean compile -Dbrowser="${BROWSER:=chrome}" -Daccessibility.timeout=5000.millis -Denvironment="${ENVIRONMENT:=QA}" -Dbrowser.option.headless=false "testOnly uk.gov.hmrc.ui.specs.GiftAidJourneySpec" testReport