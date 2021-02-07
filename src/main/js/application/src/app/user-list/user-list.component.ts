import { Component, OnInit } from '@angular/core';
import { People } from '../model/people';
import { PeopleService } from '../service/people.service';
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  people: Observable<People[]>;


  constructor(private peopleService: PeopleService) {
    this.people = this.peopleService.findAll();
  }


  ngOnInit() {
  }
}
