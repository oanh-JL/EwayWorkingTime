package eway.intern.management_staff.services

import eway.intern.management_staff.models.RawDaily

interface DailyService {

    void create(RawDaily daily)

    void update(RawDaily daily)



}